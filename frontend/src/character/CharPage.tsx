import { JSX, useState } from "react";
import { useQuery } from "@tanstack/react-query";
import { Link } from "react-router-dom";
import { Badge, Button, Checkbox, Group, MultiSelect, Paper, Stack, Table } from "@mantine/core";
import { Character, getCharactersByUser } from "@/api/character_api";
import { useAuth } from "@/login/AuthProvider";

function CharPage() {
  return (
    <>
      <Paper shadow="sm" radius="md">
        <Stack justify="center" align="center">
          <h1>Choose from all characters, everywhere!</h1>
          <Group justify="center">
            <MultiSelect
              label="By World"
              placeholder="World"
              data={["React", "Angular", "Vue", "Svelte"]}
              searchable
              nothingFoundMessage="Nothing found..."
              hidePickedOptions
              clearable
            />
            <MultiSelect
              label="By Name"
              placeholder="Character Name"
              data={["React", "Angular", "Vue", "Svelte"]}
              searchable
              nothingFoundMessage="Nothing found..."
              hidePickedOptions
              clearable
            />
            <MultiSelect
              label="By Owner"
              placeholder="Owner Name"
              data={["React", "Angular", "Vue", "Svelte"]}
              searchable
              nothingFoundMessage="Nothing found..."
              hidePickedOptions
              clearable
            />
          </Group>
          <CharTableComponent />
        </Stack>
      </Paper>
    </>
  );
}

/**
 * Table data component for CharacterDash.tsx. GETs backend data for all
 * characters owned by user in useAuth().
 *
 * @returns Rendered table component.
 */
function CharTableComponent(): JSX.Element {
  const { user } = useAuth();
  const [selectedRows, setSelectedRows] = useState<number[]>([]);

  const query = useQuery({
    queryKey: ["user-characters"],
    queryFn: () => getCharactersByUser(user?.userName),
  });

  if (query.isLoading) {
    return <div>Loading. . .</div>;
  }

  const rows = query.data?.map((char: Character, index) => (
    <Table.Tr
      key={index + char.characterName}
      bg={selectedRows.includes(char.characterId) ? "lightblue" : undefined}
    >
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
          {char.timelineName.split(",").map((str, index) => (
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
      <Button
        variant="filled"
        size="xs"
        radius="xl"
        component={Link}
        to="/activecharacter"
        state={selectedRows}
      >
        Edit Selected
      </Button>
      <Table striped highlightOnHover withTableBorder>
        <Table.Thead>
          <Table.Tr>
            <Table.Th />
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

export default CharPage;
