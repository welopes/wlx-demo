//// Em: [seu_modulo_de_app_ou_feature]/src/main/java/br/com/wlx/demo/user/data/local/model/UserEntity.kt
//// (Exemplo: dentro de um módulo/feature chamado 'user')
//package br.com.wlx.login.data.local.model
//
//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.Index
//import androidx.room.PrimaryKey
//
///**
// * Representa um usuário na tabela local do banco de dados.
// *
// * @property id Identificador único do usuário (geralmente vindo do backend).
// * @property name Nome completo do usuário. Pode ser nulo se não fornecido.
// * @property email Endereço de e-mail do usuário. Usado como chave secundária e deve ser único.
// * @property profilePictureUrl URL para a imagem de perfil do usuário. Pode ser nulo.
// * @property bio Uma breve biografia ou descrição do usuário. Pode ser nulo.
// * @property lastLoginTimestamp Timestamp do último login, para referência ou lógica de sessão.
// * @property isVerified Indica se o e-mail do usuário foi verificado.
// * @property localCreatedAt Timestamp de quando o registro foi criado localmente (útil para sincronização ou debug).
// */
//@Entity(
//    tableName = "user_table", // Nome da tabela no banco de dados SQLite
//    indices = [Index(value = ["email"], unique = true)] // Exemplo: garantir que o e-mail seja único
//)
//data class UserEntity(
//    @PrimaryKey
//    @ColumnInfo(name = "id") // Especifica o nome da coluna, embora Room infira se for igual ao nome da propriedade
//    val id: String,
//
//    @ColumnInfo(name = "name")
//    val name: String?,
//
//    @ColumnInfo(name = "email")
//    val email: String,
//
//    @ColumnInfo(name = "profile_picture_url")
//    val profilePictureUrl: String?,
//
//    @ColumnInfo(name = "bio")
//    val bio: String?,
//
//    @ColumnInfo(name = "last_login_timestamp")
//    val lastLoginTimestamp: Long?,
//
//    @ColumnInfo(name = "is_verified", defaultValue = "0") // Room precisa de valores padrão para tipos não nulos adicionados posteriormente
//    val isVerified: Boolean = false,
//
//    @ColumnInfo(name = "local_created_at", defaultValue = "CURRENT_TIMESTAMP")
//    val localCreatedAt: Long? = System.currentTimeMillis() // Pode ser preenchido automaticamente pelo Room com CURRENT_TIMESTAMP
//                                                         // ou você pode gerenciar manualmente.
//                                                         // Para Room auto-gerar, você precisaria de um TypeConverter para Long
//                                                         // se usar CURRENT_TIMESTAMP diretamente na anotação, ou definir na criação do DB.
//                                                         // Definir aqui com System.currentTimeMillis() é mais direto na entidade.
//)
