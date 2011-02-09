package org.onebusaway.users.client.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.onebusaway.users.model.properties.RouteFilter;

/**
 * A route filter, as filtered by a set of route ids. If the set of ids is empty, we
 * consider all routes to be enabled. if the set of ids is not empty, then we
 * consider only routes with ids contained in the filter set to be enabled.
 * 
 * @author bdferris
 * @see RouteFilter
 */
public final class RouteFilterBean implements Serializable {

  private static final long serialVersionUID = 1L;
  
  private Set<String> routeIds = new HashSet<String>();
  
  public RouteFilterBean() {
    
  }

  public RouteFilterBean(Set<String> routeIds) {
    this.routeIds = routeIds;
  }

  public Set<String> getRouteIds() {
    return routeIds;
  }

  public void setRouteIds(Set<String> routeIds) {
    this.routeIds = routeIds;
  }
}
