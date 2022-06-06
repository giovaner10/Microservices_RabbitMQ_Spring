package com.auth;

import java.util.Arrays;


import com.auth.entity.Permissio;
import com.auth.entity.Use;
import com.auth.repository.PermissionRepository;
import com.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BCryptPasswordEncoder encoder, UserRepository userRepository, PermissionRepository permissionRepository) {
		return args -> {
			initUsers(userRepository, permissionRepository, encoder);
		};

	}

	private void initUsers(UserRepository userRepository, PermissionRepository permissionRepository,
						   BCryptPasswordEncoder passwordEncoder) {

		Permissio permission = null;
		Permissio findPermission = permissionRepository.findByDescription("Admin");
		if (findPermission == null) {
			permission = new Permissio();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}

		Use admin = new Use();
		admin.setUserName("giovane");
		admin.setAccountNonExpired(true);
		admin.setAccountNonLocked(true);
		admin.setCredentialsNonExpired(true);
		admin.setEnabled(true);
		admin.setPassword(passwordEncoder.encode("1234"));
		admin.setPermissios(Arrays.asList(permission));

		Use find = userRepository.findByUserName("giovane");
		if (find == null) {
			userRepository.save(admin);
		}
	}

}