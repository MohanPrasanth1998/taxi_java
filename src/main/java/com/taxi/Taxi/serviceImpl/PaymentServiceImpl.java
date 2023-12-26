package com.taxi.Taxi.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxi.Taxi.dao.PaymentDao;
import com.taxi.Taxi.dto.PaymentDto;
import com.taxi.Taxi.model.Cab;
import com.taxi.Taxi.model.Payment;
import com.taxi.Taxi.service.CabService;
import com.taxi.Taxi.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private CabService cabService;

	@Override
	public Payment saveOrUpdate(PaymentDto paymentDto) {
		log.debug("Save Driver Details");
		try {
			Payment payDetails = modelMapper.map(paymentDto, Payment.class);
			return paymentDao.save(payDetails);
		} catch (Exception e) {
			log.error(e.getMessage());

			throw new RuntimeException("Failed To save");
		}

	}
	
	@Override
	public List<PaymentDto> getAllPaymentsByCab(Integer cabId){
		try {
			Cab cab= cabService.getCabById(cabId);
			return paymentDao.findBycab(cab).stream().map(payment->modelMapper.map(payment, PaymentDto.class))
					.collect(Collectors.toList());
		}catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<>();
		}
	}
	

}
