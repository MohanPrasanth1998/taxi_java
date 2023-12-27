package com.taxi.Taxi.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Component;

import com.taxi.Taxi.model.HolidayPackage;
import com.taxi.Taxi.repository.HolidayPackageRepo;

@Component
public class HolidayPackageDao implements HolidayPackageRepo {

	@Autowired
	private HolidayPackageRepo holidayPackageRepo;

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends HolidayPackage> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<HolidayPackage> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public HolidayPackage getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HolidayPackage getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HolidayPackage getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HolidayPackage> findAll() {
		// TODO Auto-generated method stub
		return holidayPackageRepo.findAll();
	}

	@Override
	public List<HolidayPackage> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> S save(S entity) {
		return holidayPackageRepo.save(entity);
	}

	@Override
	public Optional<HolidayPackage> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(HolidayPackage entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends HolidayPackage> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HolidayPackage> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<HolidayPackage> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HolidayPackage> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends HolidayPackage> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends HolidayPackage, R> R findBy(Example<S> example,
			Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HolidayPackage> findBypackageId(long packageId) {
		// TODO Auto-generated method stub
		return holidayPackageRepo.findBypackageId(packageId);
	}

	@Override
	public void deleteBypackageId(long packageId) {
		holidayPackageRepo.deleteBypackageId(packageId);
	}

}
