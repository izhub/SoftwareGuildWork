/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.DAO;

import com.swcguild.serverinventory.DTO.Server;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apprentice
 */
public interface ServerDAO {
    
    public void addServer(Server server);
    public void removeServer(int id);
    
    public Server getServer(int id);
    public List<Server> getAllServers();
    public List<Server> getServersByManufacturer(String manufacturer);
    public List<Server> getServersOlderThan(int ageInYears);
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears);
    
    public double getAverageServerAge();
}
