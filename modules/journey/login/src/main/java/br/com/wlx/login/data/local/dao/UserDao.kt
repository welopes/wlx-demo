//// Em: [seu_modulo_de_app_ou_feature]/src/main/java/br/com/wlx/demo/[nome_da_feature_ou_app]/data/local/dao/UserDao.kt
//package br.com.wlx.login.data.local.dao // Exemplo: dentro de um feature 'user'
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import androidx.room.Update
//import br.com.wlx.demo.user.data.local.model.UserEntity // Entidade User específica para este módulo
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface UserDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: UserEntity)
//
//    @Update
//    suspend fun updateUser(user: UserEntity)
//
//    @Query("SELECT * FROM user_table WHERE id = :userId") // Supondo que sua tabela se chame 'user_table'
//    fun getUserById(userId: String): Flow<UserEntity?>
//
//    @Query("SELECT * FROM user_table WHERE email = :email LIMIT 1")
//    suspend fun getUserByEmail(email: String): UserEntity?
//
//    @Query("SELECT * FROM user_table")
//    fun getAllUsers(): Flow<List<UserEntity>>
//
//    @Query("DELETE FROM user_table WHERE id = :userId")
//    suspend fun deleteUserById(userId: String)
//
//    @Query("DELETE FROM user_table")
//    suspend fun clearAllUsers()
//}
