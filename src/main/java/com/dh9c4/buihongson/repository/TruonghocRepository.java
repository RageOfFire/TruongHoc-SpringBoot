package com.dh9c4.buihongson.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh9c4.buihongson.model.Truonghoc;

public interface TruonghocRepository extends JpaRepository<Truonghoc, Long> {
	List<Truonghoc> findByDadonghocphi(boolean dadonghocphi);
	List<Truonghoc> findByTensvContaining(String tensv);
}
