package attestation_2.spring.controllers;

import attestation_2.spring.exceptions.ResourceNotFoundException;
import attestation_2.spring.models.Role;
import attestation_2.spring.models.Role;
import attestation_2.spring.repsoitories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RoleController {
    private final RoleRepository roleRepository;
    
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/roles")
    public Page<Role> getRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @GetMapping("/roles/{roleId}")
    public Role getRoles(@PathVariable int roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));
    }

    @PostMapping("/roles")
    public Role createRole(@Valid @RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/roles/{roleId}")
    public Role updateRole(@PathVariable int roleId, @Valid @RequestBody Role roleRequest) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    role.setName(roleRequest.getName());
                    return roleRepository.save(role);
                }).orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));
    }

    @DeleteMapping("/roles/{roleId}")
    public ResponseEntity<?> deleteRole(@PathVariable int roleId) {
        return roleRepository.findById(roleId)
                .map(role -> {
                    roleRepository.delete(role);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));
    }
}
