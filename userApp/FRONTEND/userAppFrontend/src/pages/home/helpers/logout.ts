
export const logoutButton = (navigate : (path: string) => void) =>{

    

    localStorage.removeItem("token")
    localStorage.removeItem("correo")


    navigate("/login")
}