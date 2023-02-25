package tn.suptech.examenspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.examenspring.domain.Role;
import tn.suptech.examenspring.repository.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long roleId) throws Exception {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent()) {
            return role.get();
        } else {
            throw new Exception("Role not found with id " + roleId);
        }
    }

    public Role updateRole(Long roleId, Role roleDetails) throws Exception {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent()) {
            Role existingRole = role.get();
            existingRole.setName(roleDetails.getName());
            existingRole.setRoleDescription(roleDetails.getRoleDescription());
            return roleRepository.save(existingRole);
        } else {
            throw new Exception("Role not found with id " + roleId);
        }
    }

    public boolean deleteRole(Long roleId) throws Exception {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent()) {
            roleRepository.deleteById(roleId);
            return true;
        } else {
            throw new Exception("Role not found with id " + roleId);
        }
    }
}
