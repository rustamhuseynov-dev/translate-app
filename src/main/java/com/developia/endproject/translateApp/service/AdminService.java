package com.developia.endproject.translateApp.service;

import org.springframework.validation.BindingResult;

import com.developia.endproject.translateApp.dto.AdminDto;
import com.developia.endproject.translateApp.dto.SelectAdminDto;

public interface AdminService {

	AdminDto signUp(AdminDto adminDto, BindingResult br);

	AdminDto selectAdmin(SelectAdminDto selectAdminDto);

}
