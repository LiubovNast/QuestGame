package com.nastoiashcha.magic.service;

import com.nastoiashcha.magic.entity.Faculty;
import com.nastoiashcha.magic.entity.Houses;

public interface FacultyService {

    Faculty getByName(Houses name);
}
