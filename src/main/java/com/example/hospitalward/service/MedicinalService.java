package com.example.hospitalward.service;

import com.example.hospitalward.model.Medicinal;
import com.example.hospitalward.util.Page;
import com.github.pagehelper.PageInfo;

public interface MedicinalService {
    PageInfo list(Medicinal medicinal, Page page) throws Exception;

    Integer create(Medicinal medicinal) throws Exception;

    Integer edit(Medicinal medicinal) throws Exception;
}
