/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author luccaskammer
 */
public class pesquisadorDeArquivos {

    public void pesquisaArquivoPorNome() throws FileNotFoundException {

        File f = null;
        File[] caminhos;

        try {
            /*Aqui é definida a pasta dos arquivos a serem pesquisados. Em um projeto JSF você pode usar a linha abaixo,
            para pegar o diretório dinamicamente. */

            //f = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("SEU CAMINHO")); <=== Utilize isso em um projeto JSF
            f = new File("\\documentos\\fotos"); //Neste exemplo será usada uma pasta qualquer

            //Esse é o filtro do arquivo. Neste exemplo está verificando se o arquivo é de fato um arquivo e se o nome começa com 12345.
            final FileFilter filter = (File pathname) -> pathname.isFile() && pathname.getName().toLowerCase().startsWith("12345");

            //Utilizando o filtro, esse array de Files é preenchido com os arquivos que bateram.
            caminhos = f.listFiles(filter);

            /*Feito isso você pode processar esse array da maneira que preferir. 
            Neste exemplo será printada uma mensagem com o caminho completo do arquivo
            em um laço for each*/
            for (File caminho : caminhos) {
                System.out.println(caminho.getCanonicalPath());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
