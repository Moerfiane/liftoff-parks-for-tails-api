package org.launchcode.parksfortails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {
    @Autowired
    private ParksListService parksListService;
    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model){
        // perform the search using the parklistservice
        List<ParksList> searchResult = parksListService.searchParksList(keyword);
        // Add the search results to the model
        model.addAttribute("searchResults",searchresults);
        return "search";
    }
}
