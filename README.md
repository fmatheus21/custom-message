<h1 align="center">ExceptionHandler Customizada</h1>

</br></br>

## Conteúdos

* [Sobre](#sobre)
* [Como usar](#como-usar)
* [Tecnologias](#tecnologias)

</br></br>

## Sobre

<a id="sobre"></a>
<p align="left">ExceptionHandler customizada para padronizar respostas de requisições de API SpringFramework.</p>


</br></br>

## Como Usar <a id="como-usar"></a>

> No terminal, na raíz do projeto, digite <code>***mvn clean install***</code>.
> 
> No pom.xml do <code>***SEU PROJETO***</code>, coloque o import abaixo:

```xml
<dependency>
    <groupId>com.fmatheus.app</groupId>
    <artifactId>custom-exception</artifactId>
    <version>1.0.0</version>
    <type>jar</type>
</dependency>
```

> Exemplo de como utilizar na sua classe.

```java

import rule.com.custom.message.MessageResponseRule;
import handler.exception.com.custom.message.MessageResponseHandler;

@Component
public class YourClass {

    @Autowired
    private MessageResponseRule messageResponseRule;

    @Autowired
    private YourService service;

    /**
     * Retornando uma mensagem de erro.
     * @return MessageResponseHandler
     */
    public MessageResponseHandler error() {
        return this.messageResponseRule.errorNotFound();
    }

    /**
     * Retornando mensagem de erro de uma consulta, caso o id nao seja encontrado
     * @param id ID
     * @return ResponseDto
     */
    public ResponseDto findById(int id) {
        return service.findById(id).orElseThrow(() -> this.messageResponseRule.errorNotFound());
    }

}
```
</br></br>

## Tecnologias  <a id="tecnologias"></a>

![Java](https://img.shields.io/static/v1?label=Java&message=17&color=green)
![SpringFramework](https://img.shields.io/static/v1?label=springframework&message=5.3.23&color=green)
![Lombok](https://img.shields.io/static/v1?label=lombok&message=1.18.24&color=green)
![Commons](https://img.shields.io/static/v1?label=commons-lang3&message=3.12.0&color=green)
