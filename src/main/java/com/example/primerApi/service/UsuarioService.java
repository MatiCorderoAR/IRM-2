package com.example.primerApi.service;

import com.example.primerApi.exception.CandidatoNotFoundException;
import com.example.primerApi.model.Usuario;
import com.example.primerApi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository IRMRepository;

    @Autowired
    public UsuarioService(UsuarioRepository IRMRepository) {
        this.IRMRepository = IRMRepository;
    }

    /* ------------------------------ FIND ----------------------------- */
    public List<Usuario> findAllUsuarios(){
        return IRMRepository.findAll();
    }
    public Optional<Usuario> findUsuarioById(Long id) {
        return Optional.ofNullable(IRMRepository.findById(id)
                .orElseThrow(() -> new CandidatoNotFoundException(id)));
    }
    /* ------------------------------ CREATE ----------------------------- */
    public Usuario addUsuario(Usuario usuario) {
        return IRMRepository.save(usuario);
    }
    /* ------------------------------ DELETE ----------------------------- */
    public void deleteUsuario(Long id) {
        Optional<Usuario> deletedUsuario = IRMRepository.findById(id);
        if(deletedUsuario.isEmpty()){
            System.out.println("La pelicula con el id: "+ id + " no existe");
        } else {
            IRMRepository.deleteById(id);
            System.out.println("Pelicula borrada con exito!");
        }
    }
    /* ------------------------------ UPDATE ----------------------------- */
    public Optional<Usuario> updateUsuario(Usuario newUsuario, Long id) {
        Optional<Usuario> updatedUsuario = IRMRepository.findById(id);
        if ((updatedUsuario.isEmpty())) throw new CandidatoNotFoundException(id);
        else {
            return updatedUsuario.map(usuario -> {
                usuario.setTittle(newUsuario.getTittle());
                usuario.setDirector(newUsuario.getDirector());
                usuario.setBanner(newUsuario.getBanner());
                usuario.setGender(newUsuario.getGender());
                return IRMRepository.save(usuario);
            });
        }
    }
}
