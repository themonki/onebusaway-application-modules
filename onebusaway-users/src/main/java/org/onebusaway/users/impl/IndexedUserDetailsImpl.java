package org.onebusaway.users.impl;

import org.onebusaway.users.model.IndexedUserDetails;
import org.onebusaway.users.model.User;
import org.onebusaway.users.model.UserIndex;
import org.onebusaway.users.model.UserIndexKey;
import org.onebusaway.users.model.UserRole;
import org.onebusaway.users.services.StandardAuthoritiesService;

import org.springframework.security.GrantedAuthority;

import java.util.Set;

public class IndexedUserDetailsImpl extends
    org.springframework.security.userdetails.User implements IndexedUserDetails {

  private static final long serialVersionUID = 2L;

  private UserIndexKey _userIndexKey;

  public IndexedUserDetailsImpl(StandardAuthoritiesService authoritiesService,
      UserIndex userIndex) {
    super(userIndex.getId().toString(), userIndex.getCredentials(), true, true,
        true, true, getGrantedAuthoritiesForUser(authoritiesService,
            userIndex.getUser()));

    _userIndexKey = userIndex.getId();
  }

  public UserIndexKey getUserIndexKey() {
    return _userIndexKey;
  }

  public boolean isAnonymous() {
    return hasAuthority(StandardAuthoritiesService.ANONYMOUS);
  }

  public boolean isAdmin() {
    return hasAuthority(StandardAuthoritiesService.ADMINISTRATOR);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + ((_userIndexKey == null) ? 0 : _userIndexKey.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    IndexedUserDetailsImpl other = (IndexedUserDetailsImpl) obj;
    if (_userIndexKey == null) {
      if (other._userIndexKey != null)
        return false;
    } else if (!_userIndexKey.equals(other._userIndexKey))
      return false;
    return true;
  }

  private boolean hasAuthority(String authorityToCheck) {
    GrantedAuthority[] authorities = getAuthorities();
    for (GrantedAuthority authority : authorities) {
      if (authority.getAuthority().equals(authorityToCheck))
        return true;
    }
    return false;
  }

  private static GrantedAuthority[] getGrantedAuthoritiesForUser(
      StandardAuthoritiesService authoritiesService, User user) {
    Set<UserRole> roles = user.getRoles();
    GrantedAuthority[] authorities = new GrantedAuthority[roles.size()];
    int index = 0;
    for (UserRole role : roles)
      authorities[index++] = authoritiesService.getNameBasedAuthority(role.getName());
    return authorities;
  }
}
