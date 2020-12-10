/*******************************************************************************
 * Copyright (c) 2019 Georgia Tech Research Institute
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *******************************************************************************/
package edu.gatech.chai.omopv6.dba.service;

import edu.gatech.chai.omopv6.model.entity.CareSite;
import edu.gatech.chai.omopv6.model.entity.Location;

// TODO: Auto-generated Javadoc
/**
 * The Interface CareSiteService.
 */
public interface CareSiteService extends IService<CareSite> {
	
	/**
	 * Search by location.
	 *
	 * @param location the location
	 * @return the care site
	 */
	public CareSite searchByLocation(Location location);
	
	/**
	 * Search by name and location.
	 *
	 * @param careSiteName the care site name
	 * @param location the location
	 * @return the care site
	 */
	public CareSite searchByNameAndLocation(String careSiteName, Location location);
}
