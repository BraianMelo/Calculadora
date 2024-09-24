package controller;

public class CalculadoraController {
    
    private double primeiroNumero;
    private double segundoNumero;
    private int operador; // 1 para +, 2 para -, 3 para /, 4 para *
    private int etapaAtual = 1; // Controla qual número está sendo inserido (primeiro ou segundo)
    private String primeiroNumeroStr = ""; // Armazena a representação em string do primeiro número
    private String segundoNumeroStr = ""; // Armazena a representação em string do segundo número
    private boolean calculoConcluido = false; // Flag para verificar se o cálculo foi concluído
    private int contagemCalculos = 0; // Rastreamento do número de cálculos realizados

    // Adiciona número e operação à string
    public String adicionarNumero(int digito, String exibicaoAtual) {
        if (calculoConcluido) {
            // Reseta o estado se um cálculo acabou de ser feito
            exibicaoAtual = "";
            primeiroNumeroStr = "";
            segundoNumeroStr = "";
            calculoConcluido = false;
        }

        if (etapaAtual % 2 == 1) {
            // Adiciona o dígito à string do primeiro número
            primeiroNumeroStr = exibicaoAtual + digito;
        } else {
            // Adiciona o dígito à string do segundo número
            segundoNumeroStr += digito;
        }

        return exibicaoAtual + digito;
    }

    // Manipula a entrada do primeiro número e atualiza a operação
    public String manipularEntradaPrimeiroNumero(String exibicaoAtual, String operadorSimbolo) {
        ++contagemCalculos;
        if (contagemCalculos >= 2) {
            etapaAtual = 1;
            segundoNumero = Double.parseDouble(segundoNumeroStr);
            primeiroNumeroStr = calcularResultado();
            segundoNumeroStr = "";
            exibicaoAtual = primeiroNumeroStr;
            segundoNumero = 0;
        }
        if (calculoConcluido) {
            primeiroNumeroStr = "";
            segundoNumeroStr = "";
            primeiroNumero = primeiroNumero + segundoNumero;
            exibicaoAtual = Double.toString(primeiroNumero);
            primeiroNumeroStr = primeiroNumero + operadorSimbolo;
            etapaAtual++;
            calculoConcluido = false;
        }
        primeiroNumero = Double.parseDouble(exibicaoAtual);
        definirOperador(operadorSimbolo);
        ++etapaAtual;
        return exibicaoAtual + operadorSimbolo;
    }

    // Exibe o resultado do cálculo
    public String exibirResultado(String exibicaoAtual) {
        exibicaoAtual += " = ";
        segundoNumero = Double.parseDouble(segundoNumeroStr);
        ++etapaAtual;
        contagemCalculos = 0;
        calculoConcluido = true;
        return exibicaoAtual + calcularResultado();
    }

    // Realiza o cálculo
    public String calcularResultado() {
        String resultadoStr = "";
        switch (operador) {
            case 1:
                resultadoStr += primeiroNumero + segundoNumero;
                break;
            case 2:
                resultadoStr += primeiroNumero - segundoNumero;
                break;
            case 3:
                resultadoStr += primeiroNumero / segundoNumero;
                break;
            case 4:
                resultadoStr += primeiroNumero * segundoNumero;
                break;
            default:
                resultadoStr = " 0 ";
                break;
        }
        return resultadoStr;
    }

    // Adiciona um ponto decimal ao número
    public String adicionarPontoDecimal(String exibicaoAtual) {
        if (etapaAtual % 2 == 1) {
            primeiroNumeroStr = exibicaoAtual + ".";
        } else {
            segundoNumeroStr += ".";
        }
        return exibicaoAtual + ".";
    }

    // Define o operador com base no símbolo de entrada
    public void definirOperador(String operadorSimbolo) {
        switch (operadorSimbolo) {
            case " + ":
                operador = 1;
                break;
            case " - ":
                operador = 2;
                break;
            case " / ":
                operador = 3;
                break;
            case " * ":
                operador = 4;
                break;
            default:
                break;
        }
    }
}
