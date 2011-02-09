/*
 * Copyright 2008 Brian Ferris
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.onebusaway.webapp.gwt.where_library.view;

import com.google.gwt.maps.client.geom.LatLng;

public interface StopFinderInterface {

  public void query(String query);

  public void queryCurrentView();

  public void queryLocation(LatLng location, int accuracy);

  public void queryRoute(String routeId);

  public String getCurrentViewAsUrl();

  public String getStopQueryLink(String stopId);
}
