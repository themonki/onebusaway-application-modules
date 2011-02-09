package org.onebusaway.phone.actions;

import org.onebusaway.users.services.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrationCancelAction extends ActionSupport {

  private static final long serialVersionUID = 1L;

  private CurrentUserService _currentUserService;

  @Autowired
  public void setCurrentUserService(CurrentUserService currentUserService) {
    _currentUserService = currentUserService;
  }

  @Override
  public String execute() {
    _currentUserService.clearPhoneNumberRegistration();
    return SUCCESS;
  }
}
