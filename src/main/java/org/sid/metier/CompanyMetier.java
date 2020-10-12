package org.sid.metier;

import org.sid.entities.Company;
import org.sid.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

@RestController
public class CompanyMetier {
    private Date dateAvant;
    private Date dateApres;

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    @GetMapping(path = "/cheques")
    public int distribuer(Company c) throws ParseException {
        int rs=0;
        if (c.getBalance()>100 || c.getBalance() == 100){
            c.setBalance(c.getBalance()-100);
            rs=100;
             this.dateAvant = sdf.parse(String.valueOf(new Date()));
        }
        return rs;
    }

    @GetMapping(path = "/solde")
    public void calculerSolde(User u) throws ParseException {

        try {
             this.dateApres = sdf.parse(String.valueOf(new Date()));
            long diff = dateApres.getTime() - dateAvant.getTime();
            float res = (diff / (1000*60*60*24));
            if(((int) res) < 365) {
                int r = this.distribuer(u.getCompany());
                u.setBalance(u.getBalance() + r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @GetMapping(path = "/cadeau")
    public int distribuerCadeau(Company c) throws ParseException {
        int rs=0;

        LocalDateTime timePoint = LocalDateTime.now();
        int annee = timePoint.getYear();
        LocalDate dateExp = LocalDate.of(annee+1, 2, 28);
        for (LocalDate date = timePoint.toLocalDate(); date.isBefore(dateExp); date = date.plusDays(1)) {

            if (c.getBalance()>100 || c.getBalance() == 100){
                c.setBalance(c.getBalance()-100);
                rs=100;
            }
        }

        return rs;
    }

}
