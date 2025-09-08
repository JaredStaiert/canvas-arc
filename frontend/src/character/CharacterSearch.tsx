import { Group, MultiSelect, Paper, Stack } from "@mantine/core";
import CharTable from "@/character/CharTable";

function CharacterSearch() {

    return (
        <>
            <Paper
                shadow="sm"
                radius="md"
            >
                <Stack
                justify="center"
                align="center"
                >
                    <h1>Choose from all characters, everywhere!</h1>
                    <Group
                        justify="center"
                    >
                        <MultiSelect
                            label="By World"
                            placeholder="World"
                            data={['React', 'Angular', 'Vue', 'Svelte']}
                            searchable
                            nothingFoundMessage="Nothing found..."
                            hidePickedOptions
                            clearable
                        />
                        <MultiSelect
                            label="By Name"
                            placeholder="Character Name"
                            data={['React', 'Angular', 'Vue', 'Svelte']}
                            searchable
                            nothingFoundMessage="Nothing found..."
                            hidePickedOptions
                            clearable
                        />
                        <MultiSelect
                            label="By Owner"
                            placeholder="Owner Name"
                            data={['React', 'Angular', 'Vue', 'Svelte']}
                            searchable
                            nothingFoundMessage="Nothing found..."
                            hidePickedOptions
                            clearable
                        />
                    </Group>
                    <CharTable/>
                </Stack>
            </Paper>
        </>
    );
}

export default CharacterSearch;