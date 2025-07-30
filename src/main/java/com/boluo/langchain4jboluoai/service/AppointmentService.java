package com.boluo.langchain4jboluoai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boluo.langchain4jboluoai.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
