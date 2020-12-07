package attestation_2.spring.controllers;

import attestation_2.spring.exceptions.ResourceNotFoundException;
import attestation_2.spring.models.Subject;
import attestation_2.spring.repsoitories.SubjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SubjectController {
    private final SubjectRepository subjectRepository;

    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/subjects")
    public Page<Subject> getSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }

    @GetMapping("/subjects/{subjectId}")
    public Subject getSubjects(@PathVariable int subjectId) {
        return subjectRepository.findById(subjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id " + subjectId));
    }

    @GetMapping("/subjects/name/{subjectName}")
    public Subject getSubjectByName(@PathVariable String subjectName) {
        return subjectRepository.findSubjectByName(subjectName);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@Valid @RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/subjects/{subjectId}")
    public Subject updateSubject(@PathVariable int subjectId, @Valid @RequestBody Subject subjectRequest) {
        return subjectRepository.findById(subjectId)
                .map(subject -> {
                    subject.setName(subjectRequest.getName());
                    return subjectRepository.save(subject);
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with id " + subjectId));
    }

    @DeleteMapping("/subjects/{subjectId}")
    public ResponseEntity<?> deleteSubject(@PathVariable int subjectId) {
        return subjectRepository.findById(subjectId)
                .map(subject -> {
                    subjectRepository.delete(subject);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Subject not found with id " + subjectId));
    }
}
