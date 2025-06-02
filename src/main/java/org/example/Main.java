package org.example;

import org.example.exercise.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("\n**** Selecione o exercício desejado ****");
            System.out.println("01 - GET simples de todas as entidades");
            System.out.println("02 - GET de entidade específica");
            System.out.println("03 - GET de entidade inexistente");
            System.out.println("04 - GET com parâmetros na URL");
            System.out.println("05 - POST criando uma nova entidade");
            System.out.println("06 - GET da entidade criada");
            System.out.println("07 - POST para atualizar uma entidade");
            System.out.println("08 - PUT para atualizar entidade");
            System.out.println("09 - DELETE de entidade válida");
            System.out.println("10 - DELETE inválido");
            System.out.println("11 - OPTIONS com verificação de métodos");
            System.out.println("12 - Experimentos com a Simple API");
            System.out.println("0 - Sair\n");

            System.out.print("Digite o número do exercício desejado: ");
            String option = sc.nextLine();

            if(!option.matches("^(0|[1-9]|1[0-2])$")){
                System.out.println("Por favor digite um número válido");
                continue;
            }

            int value = Integer.parseInt(option);

            if (value == 0)
            {
                sc.close();
                break;
            }
            else if (value == 1)
            {
                ex01 ex01 = new ex01();
                ex01.Ex01();
            }
            else if (value == 2)
            {
                ex02 ex02 = new ex02();
                ex02.Ex02();
            }
            else if (value == 3)
            {
                ex03 ex03 = new ex03();
                ex03.Ex03();
            }
            else if (value == 4)
            {
                ex04 ex04 = new ex04();
                ex04.Ex04();
            }
            else if (value == 5)
            {
                ex05 ex05 = new ex05();
                ex05.Ex05();
            }
            else if (value == 6)
            {
                ex06 ex06 = new ex06();
                ex06.Ex06();
            }
            else if (value == 7)
            {
                ex07 ex07 = new ex07();
                ex07.Ex07();
            }
            else if (value == 8)
            {
                ex08 ex08 = new ex08();
                ex08.Ex08();
            }
            else if (value == 9)
            {
                ex09 ex09 = new ex09();
                ex09.Ex09();
            }
            else if (value == 10)
            {
                ex10 ex10 = new ex10();
                ex10.Ex10();
            }
            else if (value == 11)
            {
                ex11 ex11 = new ex11();
                ex11.Ex11();
            }
            else if (value == 12)
            {
                ex12 ex12 = new ex12();
                ex12.Ex12();
            }
        }
    }
}