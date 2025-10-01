package lopesantonio.com.de.biblioteca.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import lopesantonio.com.de.biblioteca.model.entity.Emprestimo;
import lopesantonio.com.de.biblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    private double calcularMulta(Long diasDeAtraso){
        return diasDeAtraso * 0.75;
    }

    public void registrarDevolucao(Long emprestimoId, LocalDate devolucaoEfetiva){
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
        emprestimo.setDevolucaoEfetiva(devolucaoEfetiva);
        var dataDevolucaoPrevista = emprestimo.getDataDevolucaoPrevista();
        if(devolucaoEfetiva.isAfter(dataDevolucaoPrevista)){
            var diasDeAtraso = ChronoUnit.DAYS.between(dataDevolucaoPrevista, devolucaoEfetiva);
            emprestimo.setMulta(calcularMulta(diasDeAtraso));
        }
        emprestimoRepository.save(emprestimo);


    }


}
