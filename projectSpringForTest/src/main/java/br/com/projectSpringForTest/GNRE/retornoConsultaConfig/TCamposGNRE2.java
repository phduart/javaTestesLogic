//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.07.04 at 01:01:40 PM EDT 
//


package br.com.projectSpringForTest.GNRE.retornoConsultaConfig;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TCamposGNRE2.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TCamposGNRE2"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;whiteSpace value="preserve"/&gt;
 *     &lt;enumeration value="ufFavorecida"/&gt;
 *     &lt;enumeration value="contribuinteEmitente"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_identificacao"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_identificacao_CNPJ"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_identificacao_CPF"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_identificacao_IE"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_razaoSocial"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_endereco"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_municipio"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_uf"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_cep"/&gt;
 *     &lt;enumeration value="contribuinteEmitente_telefone"/&gt;
 *     &lt;enumeration value="itensGNRE"/&gt;
 *     &lt;enumeration value="item"/&gt;
 *     &lt;enumeration value="item_receita"/&gt;
 *     &lt;enumeration value="item_detalhamentoReceita"/&gt;
 *     &lt;enumeration value="item_documentoOrigem"/&gt;
 *     &lt;enumeration value="item_produto"/&gt;
 *     &lt;enumeration value="item_referencia"/&gt;
 *     &lt;enumeration value="item_referencia_periodo"/&gt;
 *     &lt;enumeration value="item_referencia_mes"/&gt;
 *     &lt;enumeration value="item_referencia_ano"/&gt;
 *     &lt;enumeration value="item_referencia_parcela"/&gt;
 *     &lt;enumeration value="item_dataVencimento"/&gt;
 *     &lt;enumeration value="item_valorPrincipal"/&gt;
 *     &lt;enumeration value="item_valorPrincipalFecp"/&gt;
 *     &lt;enumeration value="item_valorAtualizacaoMonetaria"/&gt;
 *     &lt;enumeration value="item_valorAtualizacaoMonetariaFecp"/&gt;
 *     &lt;enumeration value="item_valorJuros"/&gt;
 *     &lt;enumeration value="item_valorJurosFecp"/&gt;
 *     &lt;enumeration value="item_valorMulta"/&gt;
 *     &lt;enumeration value="item_valorMultaFecp"/&gt;
 *     &lt;enumeration value="item_valorTotal"/&gt;
 *     &lt;enumeration value="item_valorTotalFecp"/&gt;
 *     &lt;enumeration value="valor"/&gt;
 *     &lt;enumeration value="item_convenio"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_identificacao"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_identificacao_CNPJ"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_identificacao_CPF"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_identificacao_IE"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_razaoSocial"/&gt;
 *     &lt;enumeration value="item_contribuinteDestinatario_municipio"/&gt;
 *     &lt;enumeration value="item_camposExtras"/&gt;
 *     &lt;enumeration value="item_camposExtras_campoExtra"/&gt;
 *     &lt;enumeration value="item_camposExtras_campoExtra_codigo"/&gt;
 *     &lt;enumeration value="item_camposExtras_campoExtra_valor"/&gt;
 *     &lt;enumeration value="valorGNRE"/&gt;
 *     &lt;enumeration value="dataPagamento"/&gt;
 *     &lt;enumeration value="identificadorGuia"/&gt;
 *     &lt;enumeration value="dataLimitePagamento"/&gt;
 *     &lt;enumeration value="informacoesComplementares"/&gt;
 *     &lt;enumeration value="informacoesComplementares_informacao"/&gt;
 *     &lt;enumeration value="nossoNumero"/&gt;
 *     &lt;enumeration value="dadosPagamento"/&gt;
 *     &lt;enumeration value="dadosPagamento_data"/&gt;
 *     &lt;enumeration value="dadosPagamento_autenticacao"/&gt;
 *     &lt;enumeration value="dadosPagamento_banco"/&gt;
 *     &lt;enumeration value="dadosPagamento_agencia"/&gt;
 *     &lt;enumeration value="linhaDigitavel"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TCamposGNRE2")
@XmlEnum
public enum TCamposGNRE2 {

    @XmlEnumValue("ufFavorecida")
    UF_FAVORECIDA("ufFavorecida"),
    @XmlEnumValue("contribuinteEmitente")
    CONTRIBUINTE_EMITENTE("contribuinteEmitente"),
    @XmlEnumValue("contribuinteEmitente_identificacao")
    CONTRIBUINTE_EMITENTE_IDENTIFICACAO("contribuinteEmitente_identificacao"),
    @XmlEnumValue("contribuinteEmitente_identificacao_CNPJ")
    CONTRIBUINTE_EMITENTE_IDENTIFICACAO_CNPJ("contribuinteEmitente_identificacao_CNPJ"),
    @XmlEnumValue("contribuinteEmitente_identificacao_CPF")
    CONTRIBUINTE_EMITENTE_IDENTIFICACAO_CPF("contribuinteEmitente_identificacao_CPF"),
    @XmlEnumValue("contribuinteEmitente_identificacao_IE")
    CONTRIBUINTE_EMITENTE_IDENTIFICACAO_IE("contribuinteEmitente_identificacao_IE"),
    @XmlEnumValue("contribuinteEmitente_razaoSocial")
    CONTRIBUINTE_EMITENTE_RAZAO_SOCIAL("contribuinteEmitente_razaoSocial"),
    @XmlEnumValue("contribuinteEmitente_endereco")
    CONTRIBUINTE_EMITENTE_ENDERECO("contribuinteEmitente_endereco"),
    @XmlEnumValue("contribuinteEmitente_municipio")
    CONTRIBUINTE_EMITENTE_MUNICIPIO("contribuinteEmitente_municipio"),
    @XmlEnumValue("contribuinteEmitente_uf")
    CONTRIBUINTE_EMITENTE_UF("contribuinteEmitente_uf"),
    @XmlEnumValue("contribuinteEmitente_cep")
    CONTRIBUINTE_EMITENTE_CEP("contribuinteEmitente_cep"),
    @XmlEnumValue("contribuinteEmitente_telefone")
    CONTRIBUINTE_EMITENTE_TELEFONE("contribuinteEmitente_telefone"),
    @XmlEnumValue("itensGNRE")
    ITENS_GNRE("itensGNRE"),
    @XmlEnumValue("item")
    ITEM("item"),
    @XmlEnumValue("item_receita")
    ITEM_RECEITA("item_receita"),
    @XmlEnumValue("item_detalhamentoReceita")
    ITEM_DETALHAMENTO_RECEITA("item_detalhamentoReceita"),
    @XmlEnumValue("item_documentoOrigem")
    ITEM_DOCUMENTO_ORIGEM("item_documentoOrigem"),
    @XmlEnumValue("item_produto")
    ITEM_PRODUTO("item_produto"),
    @XmlEnumValue("item_referencia")
    ITEM_REFERENCIA("item_referencia"),
    @XmlEnumValue("item_referencia_periodo")
    ITEM_REFERENCIA_PERIODO("item_referencia_periodo"),
    @XmlEnumValue("item_referencia_mes")
    ITEM_REFERENCIA_MES("item_referencia_mes"),
    @XmlEnumValue("item_referencia_ano")
    ITEM_REFERENCIA_ANO("item_referencia_ano"),
    @XmlEnumValue("item_referencia_parcela")
    ITEM_REFERENCIA_PARCELA("item_referencia_parcela"),
    @XmlEnumValue("item_dataVencimento")
    ITEM_DATA_VENCIMENTO("item_dataVencimento"),
    @XmlEnumValue("item_valorPrincipal")
    ITEM_VALOR_PRINCIPAL("item_valorPrincipal"),
    @XmlEnumValue("item_valorPrincipalFecp")
    ITEM_VALOR_PRINCIPAL_FECP("item_valorPrincipalFecp"),
    @XmlEnumValue("item_valorAtualizacaoMonetaria")
    ITEM_VALOR_ATUALIZACAO_MONETARIA("item_valorAtualizacaoMonetaria"),
    @XmlEnumValue("item_valorAtualizacaoMonetariaFecp")
    ITEM_VALOR_ATUALIZACAO_MONETARIA_FECP("item_valorAtualizacaoMonetariaFecp"),
    @XmlEnumValue("item_valorJuros")
    ITEM_VALOR_JUROS("item_valorJuros"),
    @XmlEnumValue("item_valorJurosFecp")
    ITEM_VALOR_JUROS_FECP("item_valorJurosFecp"),
    @XmlEnumValue("item_valorMulta")
    ITEM_VALOR_MULTA("item_valorMulta"),
    @XmlEnumValue("item_valorMultaFecp")
    ITEM_VALOR_MULTA_FECP("item_valorMultaFecp"),
    @XmlEnumValue("item_valorTotal")
    ITEM_VALOR_TOTAL("item_valorTotal"),
    @XmlEnumValue("item_valorTotalFecp")
    ITEM_VALOR_TOTAL_FECP("item_valorTotalFecp"),
    @XmlEnumValue("valor")
    VALOR("valor"),
    @XmlEnumValue("item_convenio")
    ITEM_CONVENIO("item_convenio"),
    @XmlEnumValue("item_contribuinteDestinatario")
    ITEM_CONTRIBUINTE_DESTINATARIO("item_contribuinteDestinatario"),
    @XmlEnumValue("item_contribuinteDestinatario_identificacao")
    ITEM_CONTRIBUINTE_DESTINATARIO_IDENTIFICACAO("item_contribuinteDestinatario_identificacao"),
    @XmlEnumValue("item_contribuinteDestinatario_identificacao_CNPJ")
    ITEM_CONTRIBUINTE_DESTINATARIO_IDENTIFICACAO_CNPJ("item_contribuinteDestinatario_identificacao_CNPJ"),
    @XmlEnumValue("item_contribuinteDestinatario_identificacao_CPF")
    ITEM_CONTRIBUINTE_DESTINATARIO_IDENTIFICACAO_CPF("item_contribuinteDestinatario_identificacao_CPF"),
    @XmlEnumValue("item_contribuinteDestinatario_identificacao_IE")
    ITEM_CONTRIBUINTE_DESTINATARIO_IDENTIFICACAO_IE("item_contribuinteDestinatario_identificacao_IE"),
    @XmlEnumValue("item_contribuinteDestinatario_razaoSocial")
    ITEM_CONTRIBUINTE_DESTINATARIO_RAZAO_SOCIAL("item_contribuinteDestinatario_razaoSocial"),
    @XmlEnumValue("item_contribuinteDestinatario_municipio")
    ITEM_CONTRIBUINTE_DESTINATARIO_MUNICIPIO("item_contribuinteDestinatario_municipio"),
    @XmlEnumValue("item_camposExtras")
    ITEM_CAMPOS_EXTRAS("item_camposExtras"),
    @XmlEnumValue("item_camposExtras_campoExtra")
    ITEM_CAMPOS_EXTRAS_CAMPO_EXTRA("item_camposExtras_campoExtra"),
    @XmlEnumValue("item_camposExtras_campoExtra_codigo")
    ITEM_CAMPOS_EXTRAS_CAMPO_EXTRA_CODIGO("item_camposExtras_campoExtra_codigo"),
    @XmlEnumValue("item_camposExtras_campoExtra_valor")
    ITEM_CAMPOS_EXTRAS_CAMPO_EXTRA_VALOR("item_camposExtras_campoExtra_valor"),
    @XmlEnumValue("valorGNRE")
    VALOR_GNRE("valorGNRE"),
    @XmlEnumValue("dataPagamento")
    DATA_PAGAMENTO("dataPagamento"),
    @XmlEnumValue("identificadorGuia")
    IDENTIFICADOR_GUIA("identificadorGuia"),
    @XmlEnumValue("dataLimitePagamento")
    DATA_LIMITE_PAGAMENTO("dataLimitePagamento"),
    @XmlEnumValue("informacoesComplementares")
    INFORMACOES_COMPLEMENTARES("informacoesComplementares"),
    @XmlEnumValue("informacoesComplementares_informacao")
    INFORMACOES_COMPLEMENTARES_INFORMACAO("informacoesComplementares_informacao"),
    @XmlEnumValue("nossoNumero")
    NOSSO_NUMERO("nossoNumero"),
    @XmlEnumValue("dadosPagamento")
    DADOS_PAGAMENTO("dadosPagamento"),
    @XmlEnumValue("dadosPagamento_data")
    DADOS_PAGAMENTO_DATA("dadosPagamento_data"),
    @XmlEnumValue("dadosPagamento_autenticacao")
    DADOS_PAGAMENTO_AUTENTICACAO("dadosPagamento_autenticacao"),
    @XmlEnumValue("dadosPagamento_banco")
    DADOS_PAGAMENTO_BANCO("dadosPagamento_banco"),
    @XmlEnumValue("dadosPagamento_agencia")
    DADOS_PAGAMENTO_AGENCIA("dadosPagamento_agencia"),
    @XmlEnumValue("linhaDigitavel")
    LINHA_DIGITAVEL("linhaDigitavel");
    private final String value;

    TCamposGNRE2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TCamposGNRE2 fromValue(String v) {
        for (TCamposGNRE2 c: TCamposGNRE2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}