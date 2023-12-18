package org.launchcode.parksfortails.service;

import org.launchcode.parksfortails.models.ParkComment;
import org.launchcode.parksfortails.data.ParkCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkCommentService {

    @Autowired
    private ParkCommentRepository parkCommentRepository;

    public void addComment(ParkComment comment) {
        parkCommentRepository.save(comment);
    }

    public List<ParkComment> getCommentsByPark(Long parkId) {
        return parkCommentRepository.findByParkId(parkId);
    }

    // New method to update an existing comment
    public void updateComment(Long commentId, ParkComment updatedComment) {
        Optional<ParkComment> existingCommentOptional = parkCommentRepository.findById(commentId);
        if (existingCommentOptional.isPresent()) {
            ParkComment existingComment = existingCommentOptional.get();
            existingComment.setComment(updatedComment.getComment());
            // You can update other fields as needed
            parkCommentRepository.save(existingComment);
        }
    }

    // New method to delete a comment by its ID
    public void deleteComment(Long commentId) {
        parkCommentRepository.deleteById(commentId);
    }

    // New method to get a specific comment by its ID
    public ParkComment getCommentById(Long commentId) {
        return parkCommentRepository.findById(commentId).orElse(null);
    }

    // New method to get all comments
    public List<ParkComment> getAllComments() {
        return parkCommentRepository.findAll();
    }
}
