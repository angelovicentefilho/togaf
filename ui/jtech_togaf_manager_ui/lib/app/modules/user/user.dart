class User {
  final String id;
  late final String username;
  late final String password;
  late final String email;
  late final String role;

  User({
    required this.id,
    required this.username,
    required this.password,
    required this.email,
    required this.role,
  });

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json['id'],
      username: json['username'],
      password: json['password'],
      email: json['email'],
      role: json['role'],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'username': username,
      'password': password,
      'email': email,
      'role': role,
    };
  }
}
