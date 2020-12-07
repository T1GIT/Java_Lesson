package attestation_2.spring.controllers;

import attestation_2.spring.exceptions.ResourceNotFoundException;
import attestation_2.spring.models.Group;
import attestation_2.spring.repsoitories.GroupRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GroupController {
    private final GroupRepository groupRepository;

    public GroupController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @GetMapping("/groups")
    public Page<Group> getGroups(Pageable pageable) {
        return groupRepository.findAll(pageable);
    }

    @GetMapping("/groups/{groupId}")
    public Group getGroups(@PathVariable int groupId) {
        return groupRepository.findById(groupId)
                .orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
    }

    @PostMapping("/groups")
    public Group createGroup(@Valid @RequestBody Group group) {
        return groupRepository.save(group);
    }

    @PutMapping("/groups/{groupId}")
    public Group updateGroup(@PathVariable int groupId, @Valid @RequestBody Group groupRequest) {
        return groupRepository.findById(groupId)
                .map(group -> {
                    group.setName(groupRequest.getName());
                    group.setYear(groupRequest.getYear());
                    group.setSemester(groupRequest.getSemester());
                    return groupRepository.save(group);
                }).orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
    }

    @DeleteMapping("/groups/{groupId}")
    public ResponseEntity<?> deleteGroup(@PathVariable int groupId) {
        return groupRepository.findById(groupId)
                .map(group -> {
                    groupRepository.delete(group);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Group not found with id " + groupId));
    }
}
