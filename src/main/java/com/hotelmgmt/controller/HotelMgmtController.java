package com.hotelmgmt.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotelmgmt.constants.HotelMgmtConstants;
import com.hotelmgmt.entity.Hotel;
import com.hotelmgmt.entity.HotelRepository;
import com.hotelmgmt.entity.HotelRequest;
import com.hotelmgmt.exception.HotelMgmtException;
import com.hotelmgmt.util.HotelMgmtUtil;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("hotel")
public class HotelMgmtController {

	@Autowired
	HotelRepository hotelRepository;

	@GetMapping("getHotels")
	@ResponseBody
	public Object getHotels(Pageable pageable) {
		return hotelRepository.findAll(pageable);
	}

	@PostMapping("addHotel")
	@ResponseBody
	public String addHotel(@RequestBody HotelRequest hotelRequest) {

		Hotel hotel = new Hotel();
		hotel.setId(UUID.randomUUID().toString());
		hotel.setName(hotelRequest.getName());
		hotel.setCity(hotelRequest.getCity());
		hotel.setState(hotelRequest.getState());

		hotelRepository.saveAndFlush(hotel);

		return hotel.getId();
	}

	@DeleteMapping("/{hotelId}/deleteHotel")
	@ResponseBody
	public Object deleteHotel(@PathVariable("hotelId") String hotelId) {
		if (StringUtils.isNullOrEmpty(hotelId)) {
			throw new HotelMgmtException();
		}

		if (HotelMgmtUtil.checkForValidUUID(hotelId)) {
			hotelRepository.delete(hotelId);
		}

		return hotelId + HotelMgmtConstants.DELETE_SUCCESS;
	}

	@PatchMapping("/{hotelId}/patchHotel")
	@ResponseBody
	public Object patchHotel(@PathVariable("hotelId") String hotelId, @RequestBody HotelRequest hotelRequest) {
		if (StringUtils.isNullOrEmpty(hotelId)) {
			throw new HotelMgmtException();
		}

		if (HotelMgmtUtil.checkForValidUUID(hotelId)) {
			Hotel existingHotel = hotelRepository.findOne(hotelId);
			if (null != existingHotel) {
				if (HotelMgmtUtil.checkForNotNullAndEmpty(hotelRequest.getName())) {
					existingHotel.setName(hotelRequest.getName());
				}

				if (HotelMgmtUtil.checkForNotNullAndEmpty(hotelRequest.getCity())) {
					existingHotel.setCity(hotelRequest.getCity());
				}

				if (HotelMgmtUtil.checkForNotNullAndEmpty(hotelRequest.getState())) {
					existingHotel.setState(hotelRequest.getState());
				}
				
				hotelRepository.saveAndFlush(existingHotel);
			}

		}

		return hotelId + HotelMgmtConstants.DELETE_SUCCESS;
	}

}