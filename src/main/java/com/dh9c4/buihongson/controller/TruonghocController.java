package com.dh9c4.buihongson.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dh9c4.buihongson.model.Truonghoc;
import com.dh9c4.buihongson.repository.TruonghocRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TruonghocController {
	@Autowired
	TruonghocRepository truonghocRepository;
	@GetMapping("/truonghoc")
	public ResponseEntity<List<Truonghoc>> getAllTruonghoc(@RequestParam(required = false) String tensv) {
	try {
	List<Truonghoc> truonghoc = new ArrayList<Truonghoc>();
	if (tensv == null)
		truonghocRepository.findAll().forEach(truonghoc::add);
	else
		truonghocRepository.findByTensvContaining(tensv).forEach(truonghoc::add);
	if (truonghoc.isEmpty()) {
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(truonghoc, HttpStatus.OK);
	} catch (Exception e) {
	return new ResponseEntity<>(null, 
	HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/truonghoc/{MaSV}")
	public ResponseEntity<Truonghoc> getTruongById(@PathVariable("MaSV") long id) {
	Optional<Truonghoc> truonghocData = truonghocRepository.findById(id);
	if (truonghocData.isPresent()) {
	return new ResponseEntity<>(truonghocData.get(), HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@PostMapping("/truonghoc")
	public ResponseEntity<Truonghoc> createTruongHoc(@RequestBody Truonghoc truonghoc) {
	try {
	Truonghoc _truonghoc = truonghocRepository
	.save(new Truonghoc(truonghoc.getTensv(), truonghoc.getDiem(), false, truonghoc.getTenlop()));
	return new ResponseEntity<>(_truonghoc, HttpStatus.CREATED);
	} catch (Exception e) {
	return new ResponseEntity<>(null, 
	HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@PutMapping("/truonghoc/{MaSV}")
	public ResponseEntity<Truonghoc> updateTruongHoc(@PathVariable("MaSV") long id, @RequestBody Truonghoc truonghoc) {
	Optional<Truonghoc> truonghocData = truonghocRepository.findById(id);
	if (truonghocData.isPresent()) {
	Truonghoc _truonghoc = truonghocData.get();
	_truonghoc.setTensv(truonghoc.getTensv());
	_truonghoc.setDiem(truonghoc.getDiem());
	_truonghoc.setDadonghocphi(truonghoc.isDadonghocphi());
	_truonghoc.setTenlop(truonghoc.getTenlop());
	return new ResponseEntity<>(truonghocRepository.save(_truonghoc), HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("/truonghoc/{MaSV}")
	public ResponseEntity<HttpStatus> deleteTruongHoc(@PathVariable("MaSV") long id) {
	try {
	truonghocRepository.deleteById(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@DeleteMapping("/truonghoc")
	public ResponseEntity<HttpStatus> deleteAllTruongHoc() {
	try {
	truonghocRepository.deleteAll();
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	} catch (Exception e) {
	return new
	ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	@GetMapping("/truonghoc/DongHocPhi")
	public ResponseEntity<List<Truonghoc>> findByHocPhi() {
	try {
	List<Truonghoc> truonghoc = truonghocRepository.findByDadonghocphi(true);
	if (truonghoc.isEmpty()) {
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(truonghoc, HttpStatus.OK);
	} catch (Exception e) {
	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
