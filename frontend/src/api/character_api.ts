const CHARACTER_URL = `${import.meta.env.VITE_SERVER_URL}characters/`;

export type Character = {
  characterId: number;
  characterName: string;
  characterAge: number;
  characterBio: string;
  timelineName: string;
  worldName: string;
  userName: string;
};

export interface CharacterDTO {
    characterId: number;
    userName: string;
    characterName: string;
    characterAge: number;
    characterBio: string;
}
// TODO: update Character type (and backend) to more universally apply (as in CharWorkBench)

export async function getCharacters(): Promise<Character[]> {
  const response = await fetch(`${CHARACTER_URL}all-characters`, { credentials: 'include' });
  if (!response.ok) {
    throw new Error(response.statusText);
  }
  return response.json();
}

export async function getCharactersByUser(userName: string | undefined): Promise<Character[]> {
  if (!(userName === undefined)) {
    const url = new URL(`${CHARACTER_URL}user`);
    url.searchParams.append('userName', userName);

    const response = await fetch(url, { credentials: 'include' });

    if (!response.ok) {
      throw new Error(response.statusText);
    }
    return response.json();
  }
  throw new Error('userName undefined');
}

export async function getCharacterById(ids: number[]): Promise<CharacterDTO[]> {
  const url = new URL(`${CHARACTER_URL}id`);
  ids.forEach(id => url.searchParams.append("ids", String(id)));
  const response = await fetch(url, { credentials: 'include' });

  if (!response.ok) {
    throw new Error(response.statusText);
  }
    return response.json();
}
