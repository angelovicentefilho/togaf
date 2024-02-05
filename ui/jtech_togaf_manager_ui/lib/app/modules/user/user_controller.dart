import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart';
import 'package:get/get.dart';

class UserController extends GetxController {
  List<User> _users = []; // Lista de usuários (simulando um banco de dados)

  UserController() {
    // Exemplos de usuários fictícios
    _users = [
      User(
          id: '1',
          username: 'user1',
          password: 'password1',
          email: 'user1@example.com',
          role: 'ADMIN'),
      User(
          id: '2',
          username: 'user2',
          password: 'password2',
          email: 'user2@example.com',
          role: 'ANALYST'),
      User(
          id: '3',
          username: 'user3',
          password: 'password3',
          email: 'user3@example.com',
          role: 'DEVELOPER'),
      User(
          id: '4',
          username: 'user4',
          password: 'password4',
          email: 'user4@example.com',
          role: 'PROJECT_MANAGER'),
      User(
          id: '5',
          username: 'user5',
          password: 'password5',
          email: 'user5@example.com',
          role: 'ARCHITECT'),
    ];
  }

  List<User> get users => _users;

  void addUser(User user) {
    _users.add(user);
    // Aqui você pode adicionar lógica para enviar o usuário para um servidor ou armazená-lo localmente
  }

  void updateUser(User user) {
    // Implemente a lógica de atualização do usuário, se necessário
  }

  List<User> getAllUsers() {
    return _users;
  }
}
