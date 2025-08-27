const USER_URL = `${import.meta.env.VITE_SERVER_URL}users/`;

export type User = {
  userName: string;
  email: string;
};

export async function getUserData(userName: string | undefined): Promise<User> {
  if (!(userName === undefined)) {
    const response = await fetch(`${USER_URL}${encodeURIComponent(userName)}`, {
      credentials: 'include',
    });
    if (!response.ok) {
      throw new Error(response.statusText);
    }
    return response.json();
  }
  throw new Error('userName undefined');
}
