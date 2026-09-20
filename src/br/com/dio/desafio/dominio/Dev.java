package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private UUID id = UUID.randomUUID(); // Identificador único automático
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public double calcularProgressoPercentual() {
        int total = this.conteudosInscritos.size() + this.conteudosConcluidos.size();
        if (total == 0) return 0.0;
        return ((double) this.conteudosConcluidos.size() / total) * 100.0;
    }

    public double calcularNotaDesempenho(Bootcamp bootcamp) {
        double xpTotal = bootcamp.calcularXpTotalBootcamp();
        if (xpTotal == 0) return 0.0;
        return Math.min((calcularTotalXp() / xpTotal) * 10.0, 10.0);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    // Apenas o ID imutável define a igualdade do objeto
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(id, dev.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}