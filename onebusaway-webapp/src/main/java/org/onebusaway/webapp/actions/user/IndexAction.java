package org.onebusaway.webapp.actions.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.onebusaway.users.client.model.UserBean;
import org.onebusaway.users.client.model.UserIndexBean;
import org.onebusaway.users.services.UserIndexTypes;
import org.onebusaway.webapp.actions.AbstractAction;

import com.opensymphony.xwork2.ModelDriven;

public class IndexAction extends AbstractAction implements
    ModelDriven<IndexModel> {

  private static final long serialVersionUID = 1L;

  private IndexModel _model = new IndexModel();

  @Override
  public IndexModel getModel() {
    return _model;
  }

  @Override
  @Actions( {
      @Action(value = "/user/index"),
      @Action(value = "/where/iphone/user/index"),
      @Action(value = "/where/text/user/index")})
  public String execute() {

    UserBean user = getCurrentUser();

    _model.setUser(user);

    List<UserIndexBean> phoneIndices = new ArrayList<UserIndexBean>();
    for (UserIndexBean index : user.getIndices()) {
      if (index.getType().equals(UserIndexTypes.PHONE_NUMBER))
        phoneIndices.add(index);
    }

    Collections.sort(phoneIndices);

    _model.setPhoneIndices(phoneIndices);

    return SUCCESS;
  }
}
