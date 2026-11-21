package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleReportDTO> findByDate(String dateOne, String dateTwo, String name, Pageable pageable) {
		if(dateOne == null && dateTwo == null && name == null) {
			LocalDate maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

			LocalDate minDate = maxDate.minusYears(1L);


			Page<Sale> result = repository.findByDate(minDate, maxDate, name, pageable);

			return result.map(sale -> new SaleReportDTO(sale));
		}
		if(dateOne == null && dateTwo == null) {
			LocalDate maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

			LocalDate minDate = maxDate.minusYears(1L);



			Page<Sale> result = repository.findByDate(minDate, maxDate, name, pageable);

			return result.map(sale -> new SaleReportDTO(sale));
		}


		if(dateOne == null ) {
			LocalDate maxDate = LocalDate.parse(dateTwo);
			LocalDate minDate = maxDate.minusYears(1L);

			Page<Sale> result = repository.findByDate(minDate, maxDate, name, pageable);

			return result.map(sale -> new SaleReportDTO(sale));


		} else if(dateTwo == null) {
			LocalDate maxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			LocalDate minDate = LocalDate.parse(dateOne);

			Page<Sale> result = repository.findByDate(minDate, maxDate, name, pageable);

			return result.map(sale -> new SaleReportDTO(sale));
		}

		LocalDate maxDate = LocalDate.parse(dateTwo);
		LocalDate minDate = LocalDate.parse(dateOne);

		Page<Sale> result = repository.findByDate(minDate, maxDate, name, pageable);

		return result.map(sale -> new SaleReportDTO(sale));

	}
}
