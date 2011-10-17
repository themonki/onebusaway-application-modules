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
package org.onebusaway.transit_data_federation.services.realtime;

import org.onebusaway.transit_data_federation.services.blocks.BlockInstance;
import org.onebusaway.transit_data_federation.services.transit_graph.BlockStopTimeEntry;
import org.onebusaway.transit_data_federation.services.transit_graph.StopTimeEntry;

public class ArrivalAndDepartureTime {

  private long arrivalTime;

  private long departureTime;

  public ArrivalAndDepartureTime(long arrivalTime, long departureTime) {
    this.arrivalTime = arrivalTime;
    this.departureTime = departureTime;
  }

  public long getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(long arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public long getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(long departureTime) {
    this.departureTime = departureTime;
  }

  public static ArrivalAndDepartureTime getScheduledTime(
      BlockInstance blockInstance, BlockStopTimeEntry blockStopTime) {
    return getScheduledTime(blockInstance, blockStopTime, 0);
  }

  public static ArrivalAndDepartureTime getScheduledTime(
      BlockInstance blockInstance, BlockStopTimeEntry blockStopTime, int offset) {

    StopTimeEntry stopTime = blockStopTime.getStopTime();

    long arrivalTime = blockInstance.getServiceDate()
        + (stopTime.getArrivalTime() + offset) * 1000;
    long departureTime = blockInstance.getServiceDate()
        + (stopTime.getDepartureTime() + offset) * 1000;

    return new ArrivalAndDepartureTime(arrivalTime, departureTime);
  }
}