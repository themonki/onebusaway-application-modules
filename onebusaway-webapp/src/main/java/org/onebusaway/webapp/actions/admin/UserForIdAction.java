/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.webapp.actions.admin;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.onebusaway.users.client.model.UserBean;
import org.onebusaway.users.model.User;
import org.onebusaway.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Results( {@Result(location = "user.jspx")})
public class UserForIdAction extends ActionSupport implements
    ModelDriven<UserBean> {

  private static final long serialVersionUID = 1L;

  private int _id;

  private UserService _userService;

  private UserBean _user;

  @Autowired
  public void setUserService(UserService userService) {
    _userService = userService;
  }

  public void setId(int id) {
    _id = id;
  }

  @Override
  public UserBean getModel() {
    return _user;
  }

  @Override
  @Actions( {
      @Action(value = "/admin/user-for-id")})
  public String execute() {

    User user = _userService.getUserForId(_id);
    
    if (user == null)
      return INPUT;

    _user = _userService.getUserAsBean(user);

    return SUCCESS;
  }
}
