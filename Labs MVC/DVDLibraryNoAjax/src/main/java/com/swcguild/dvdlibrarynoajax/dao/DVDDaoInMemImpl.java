/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrarynoajax.dao;

import com.swcguild.dvdlibrarynoajax.model.DVD;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
// implements DVDDao interface
public class DVDDaoInMemImpl implements DVDDao {

    private Map<Integer, DVD> dvdMap = new HashMap<>();

    private static int dvdIdCounter = 0;

    //add abstract of implementation
    @Override
    public DVD addDvd(DVD dvd) {

        dvd.setDvdId(dvdIdCounter);
        dvdIdCounter++;
        dvdMap.put(dvd.getDvdId(), dvd);
        return dvd;
    }

    @Override
    public void removeDvd(int dvdId) {
        dvdMap.remove(dvdId);

    }

    @Override
    public void updateDvd(DVD dvd) {
        dvdMap.put(dvd.getDvdId(), dvd);
    }

    @Override
    public List<DVD> getAllDvds() {
        Collection<DVD> c = dvdMap.values();
        return new ArrayList(c);
    }

    @Override
    public DVD getDvdById(int dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public List<DVD> searchDvds(Map<SearchTerm, String> criteria) {

        // get all search terms from the map
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String mpaaRatingCriteria = criteria.get(SearchTerm.MPAA_RATING);
        String releaseDateCriteria = criteria.get(SearchTerm.RELEASE_DATE);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);

        //declare all the predicate conditions
        //is boolean based functional interface that can be used as the
        // assignment target for a lambda expression or method reference
        Predicate<DVD> titleMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> mpaaRatingMatches;
        Predicate<DVD> releaseDateMatches;
        Predicate<DVD> studioMatches;

        //placeholder predicate - always returns true. 
        //used for search terms that are empty
        Predicate<DVD> truePredicate = (d) -> {
            return true;
        };

        //Assign values to predicates. 
        //if given search term is empty, assign default truePredicate; 
        // otehrwise assign predicate that properly filters for given term
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getTitle().equalsIgnoreCase(titleCriteria);

        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getDirector().equalsIgnoreCase(directorCriteria);

        mpaaRatingMatches = (mpaaRatingCriteria == null || mpaaRatingCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getMpaaRating().equalsIgnoreCase(mpaaRatingCriteria);

        releaseDateMatches = (releaseDateCriteria == null || releaseDateCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getReleaseDate().equals(releaseDateCriteria);

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (d) -> d.getStudio().equalsIgnoreCase(studioCriteria);

        //Return lisit of dvds that match given criteria. To do this:
        // we AND  all predicates together in a filter operation
        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(directorMatches)
                        .and(mpaaRatingMatches)
                        .and(releaseDateMatches)
                        .and(studioMatches))
                .collect((Collectors.toList()));

    }

}
