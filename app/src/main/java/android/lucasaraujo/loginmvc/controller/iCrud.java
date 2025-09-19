package android.lucasaraujo.loginmvc.controller;

import java.util.List;

public interface iCrud <T>{
    public boolean incluir(T obj);
    public boolean alterar(T obj);
    public boolean deletar(T obj);
    public List<T> listar();
}
