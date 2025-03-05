package crud.products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Products API")
                        .version("1.0")
                        .description("A API para gerenciamento de produtos, permitindo operações completas de CRUD (Create, Read, Update, Delete). " +
                                "Ela oferece os seguintes endpoints: " +
                                "1. **Registrar produto**: Cria um novo produto no sistema. " +
                                "2. **Atualizar produto**: Atualiza as informações de um produto existente. " +
                                "3. **Buscar produto**: Obtém os detalhes de um produto pelo ID. " +
                                "4. **Listar produtos**: Retorna todos os produtos cadastrados no sistema. " +
                                "5. **Deletar produto**: Remove um produto do sistema."));
    }

}

