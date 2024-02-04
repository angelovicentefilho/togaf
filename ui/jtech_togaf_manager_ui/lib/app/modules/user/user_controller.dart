import 'package:jtech_togaf_manager_ui/app/modules/user/user.dart'; // Importe o modelo de usuário

class UserController {
  List<User> _users = []; // Lista de usuários (simulando um banco de dados)

  List<User> get users => _users;

  void addUser(User user) {
    _users.add(user);
    // Aqui você pode adicionar lógica para enviar o usuário para um servidor ou armazená-lo localmente
  }
}
