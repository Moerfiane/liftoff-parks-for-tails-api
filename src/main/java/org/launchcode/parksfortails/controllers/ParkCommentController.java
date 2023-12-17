package org.launchcode.parksfortails.controllers;

import org.launchcode.parksfortails.models.ParkComment;
import org.launchcode.parksfortails.service.ParkCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")  // Base URL for comment-related endpoints
public class ParkCommentController {

    @Autowired
    private ParkCommentService parkCommentService;

    // Endpoint to add a new comment to a park
    @PostMapping("/add")
    public void addComment(@RequestBody ParkComment comment) {
        // Delegate the comment addition to the service
        parkCommentService.addComment(comment);
    }

    // Endpoint to get all comments for a specific park
    @GetMapping("/{parkId}")
    public List<ParkComment> getCommentsByPark(@PathVariable Long parkId) {
        // Delegate the comment retrieval to the service
        return parkCommentService.getCommentsByPark(parkId);
    }

    // Additional endpoint to update an existing comment
    @PutMapping("/update/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody ParkComment updatedComment) {
        // Delegate the comment update to the service
        parkCommentService.updateComment(commentId, updatedComment);
    }

    // Additional endpoint to delete a comment by its ID
    @DeleteMapping("/delete/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        // Delegate the comment deletion to the service
        parkCommentService.deleteComment(commentId);
    }

    // Additional endpoint to get a specific comment by its ID
    @GetMapping("/get/{commentId}")
    public ParkComment getCommentById(@PathVariable Long commentId) {
        // Delegate the comment retrieval to the service
        return parkCommentService.getCommentById(commentId);
    }

    // Additional endpoint to get all comments (without specifying a park)
    @GetMapping("/all")
    public List<ParkComment> getAllComments() {
        // Delegate the retrieval of all comments to the service
        return parkCommentService.getAllComments();
    }
}
