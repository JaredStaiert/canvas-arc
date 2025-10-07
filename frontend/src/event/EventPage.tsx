import { JSX } from "react";
import { Group, MultiSelect, Paper, Stack } from "@mantine/core";

function EventPage() {
  return (
    <>
      <Paper shadow="sm" radius="md">
        <Stack justify="center" align="center">
          <h1>All Events</h1>
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
          <EventTableComponent />
        </Stack>
      </Paper>
    </>
  );
}

function EventTableComponent(): JSX.Element {
  return (
      <>
          <h2>Here Table</h2>
      </>
  );
}

export default EventPage;