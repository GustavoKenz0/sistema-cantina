function pesquisarProdutos() {
      const searchTerm = document.getElementById("searchInput").value.toLowerCase();
      const produtos = document.querySelectorAll(".product-item");

      produtos.forEach(produto => {
        const nomeProduto = produto.querySelector(".product-info h5").textContent.toLowerCase();
        const descricaoProduto = produto.querySelector(".product-info p").textContent.toLowerCase();

        if (nomeProduto.includes(searchTerm) || descricaoProduto.includes(searchTerm)) {
          produto.style.display = "block";
        } else {
          produto.style.display = "none";
        }
      });
    }