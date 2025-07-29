import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// Essa é a nossa janela principal com o menu de cadastro
public class CadastroClienteGUI extends JFrame {
    private ArrayList<String> listaClientes = new ArrayList<>(); //  Aqui guardamos os nomes

    public CadastroClienteGUI() {
        setTitle("Cadastro de Clientes"); // 🏷 Título da janela
        setSize(400, 300); // 📐 Tamanho da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //  Fechar ao clicar no X
        setLocationRelativeTo(null); //  Centralizar janela

        // Criando o layout da tela
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 1));

        //  Criando os botões
        JButton btnCadastrar = new JButton("Cadastrar Cliente");
        JButton btnListar = new JButton("Listar Clientes");
        JButton btnAtualizar = new JButton("Atualizar Cliente");
        JButton btnRemover = new JButton("Remover Cliente");

        //  Ações de cada botão
        btnCadastrar.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
            if (nome != null && !nome.trim().isEmpty()) {
                listaClientes.add(nome.trim());
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
            }
        });

        btnListar.addActionListener(e -> {
            if (listaClientes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nenhum cliente cadastrado.");
            } else {
                StringBuilder lista = new StringBuilder();
                for (int i = 0; i < listaClientes.size(); i++) {
                    lista.append(i).append(" - ").append(listaClientes.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(this, lista.toString());
            }
        });

        btnAtualizar.addActionListener(e -> {
            String posStr = JOptionPane.showInputDialog("Digite o número do cliente para atualizar:");
            try {
                int pos = Integer.parseInt(posStr);
                if (pos >= 0 && pos < listaClientes.size()) {
                    String novoNome = JOptionPane.showInputDialog("Novo nome:");
                    listaClientes.set(pos, novoNome);
                    JOptionPane.showMessageDialog(this, "Cliente atualizado!");
                } else {
                    JOptionPane.showMessageDialog(this, "Número inválido.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: Digite um número válido.");
            }
        });

        btnRemover.addActionListener(e -> {
            String posStr = JOptionPane.showInputDialog("Digite o número do cliente para remover:");
            try {
                int pos = Integer.parseInt(posStr);
                if (pos >= 0 && pos < listaClientes.size()) {
                    listaClientes.remove(pos);
                    JOptionPane.showMessageDialog(this, "Cliente removido.");
                } else {
                    JOptionPane.showMessageDialog(this, "Número inválido.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: Digite um número válido.");
            }
        });

        //  Adicionando os botões ao painel
        painel.add(btnCadastrar);
        painel.add(btnListar);
        painel.add(btnAtualizar);
        painel.add(btnRemover);

        //  Mostrando o painel na janela
        add(painel);
    }

    public static void main(String[] args) {
        // Iniciar a interface
        SwingUtilities.invokeLater(() -> {
            new CadastroClienteGUI().setVisible(true);
        });
    }
}

