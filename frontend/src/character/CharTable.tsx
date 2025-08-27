import { useState } from 'react';
import { useQuery } from "@tanstack/react-query";
import { Badge, Checkbox, Group, Table } from '@mantine/core';
import { Character, getCharactersByUser } from '@/api/character_api';
import { useAuth } from '@/login/AuthProvider';


function CharTable() {
    const { user } = useAuth();
    const [selectedRows, setSelectedRows] = useState<number[]>([]);

    const query = useQuery({
      queryKey: ["user-characters"],
      queryFn: () => getCharactersByUser(user?.userName)
    });

    if (query.isLoading) {
        return <div>Loading. . .</div>
    }

    const rows = query.data?.map((char: Character, index) => (
      <Table.Tr
        key={index + char.characterName}
        bg={selectedRows.includes(char.characterId) ? 'lightblue' : undefined}
      >
        {/*<Table.Td>{char.characterId}</Table.Td>*/}
        <Table.Td>
          <Checkbox
            aria-label="Select row"
            checked={selectedRows.includes(char.characterId)}
            onChange={(event) => {
              if (event.currentTarget.checked) {
                setSelectedRows([...selectedRows, char.characterId]);
              } else {
                setSelectedRows(selectedRows.filter((position) => position !== char.characterId));
              }
            }}
          />
        </Table.Td>
        <Table.Td>{char.userName}</Table.Td>
        <Table.Td>{char.characterName}</Table.Td>
        <Table.Td>{char.characterAge}</Table.Td>
        <Table.Td>
          <Group gap="xs">
            {char.timelineName.split(',').map((str, index) => (
              <Badge key={index + char.timelineName} color="green" radius="sm">
                {str}
              </Badge>
            ))}
          </Group>
        </Table.Td>
        <Table.Td>{char.worldName}</Table.Td>
        <Table.Td>{char.characterBio}</Table.Td>
      </Table.Tr>
    ));

    return (
        <>
            <Table
              striped
              highlightOnHover
              withTableBorder
            >
                <Table.Thead>
                    <Table.Tr>
                        <Table.Th/>
                        <Table.Th>User Name</Table.Th>
                        <Table.Th>Character Name</Table.Th>
                        <Table.Th>Age</Table.Th>
                        <Table.Th>Timeline</Table.Th>
                        <Table.Th>World</Table.Th>
                        <Table.Th>Bio</Table.Th>
                    </Table.Tr>
                </Table.Thead>
                <Table.Tbody>{rows}</Table.Tbody>
            </Table>
        </>
    );

}

export default CharTable;