/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.serverinventory.DAO;

import com.swcguild.serverinventory.DTO.Server;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class ServerDAOInMemImpl implements ServerDAO {

    private static int counter = 0;

    private Map<Integer, Server> servers = new HashMap<>();

    @Override
    public void addServer(Server server) {
        server.setId(counter++);
        servers.put(server.getId(), server);
    }

    @Override
    public Server getServer(int id) {
        return servers.get(id);
    }

    @Override
    public void removeServer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Server> getServersByManufacturer(String manufacturer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
//simplified way
        return servers.values().stream() //we'r returning a list so get values
                .filter(myServer -> myServer.getServerAge() > ageInYears) //push things through filter
                .collect(Collectors.toList()); // things left over, hand back to us in a list
    }

    @Override
    public Map<String, List<Server>> getServersOlderThanGroupByMake(int ageInYears) {
// robust way; exact same lambda as above
        return servers.values().stream()
                .filter((Server myServer) -> {return myServer.getServerAge() > ageInYears;}) //must have explicit statement ex: return
                .collect(Collectors.groupingBy(myServer -> myServer.getMake()));
    }

    @Override
    public double getAverageServerAge() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Server> getAllServers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
