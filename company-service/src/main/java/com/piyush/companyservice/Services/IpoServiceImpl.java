package com.piyush.companyservice.Services;

import java.util.List;
import java.util.Optional;

import com.piyush.companyservice.Entities.Ipo;
import com.piyush.companyservice.Repository.CodesRepository;
import com.piyush.companyservice.Repository.CompanyRepository;
import com.piyush.companyservice.Repository.IpoRepository;
import com.piyush.models.Dates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IpoServiceImpl implements IpoService {


    @Autowired
    IpoRepository ipoRepository;
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    CodesRepository codesRepository;

    @Override
    public Ipo addIpo(Ipo ipo) {
        return ipoRepository.save(ipo);
    }

    @Override
    public List<Ipo> getAllIpoByCompany(String name) {
        Integer id = companyRepository.findByCompanyName(name).getid();
        List<Integer> codes = codesRepository.findByCompanyId(id);
        List<Ipo> ipos = ipoRepository.findByCompanyCodeInOrderByDate(codes);
        return ipos;
    }

    @Override
    public List<Ipo> getIpoByCompanyStockEx(String name, Integer stockCode) {
        Integer id = companyRepository.findByCompanyName(name).getid();
        Integer code = codesRepository.findCompanyCodeByCompanyIdAndStockCode(id, stockCode).getCompanyCode();
        return ipoRepository.findByCompanyCodeOrderByDate(code);
    }

    @Override
    public List<Ipo> getIpoByRange(Dates dates, String name) {
        Integer id = companyRepository.findByCompanyName(name).getid();
        List<Integer> codes = codesRepository.findByCompanyId(id);
        return ipoRepository.findStockInRange(codes, dates.getStartDate(), dates.getEndDate());
    }

    @Override
    public List<Ipo> getAllIpo() {
        return ipoRepository.findAll();
    }

    @Override
    public Ipo getIpo(Integer id) {
        Optional<Ipo> ipo = ipoRepository.findById(id);

        return ipo.get();
    }

}
